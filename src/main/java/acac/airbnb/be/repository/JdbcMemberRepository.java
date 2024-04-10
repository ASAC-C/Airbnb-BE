package acac.airbnb.be.repository;

import acac.airbnb.be.domain.MemberDto;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class JdbcMemberRepository implements  MemberRepository{
    private final DataSource dataSource;

    // 생성자를 통해 dataSource 주입
    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 회원 정보를 저장
     * sql문을 통해 value들을 주입 시킴
     */
    @Override
    public MemberDto save(MemberDto member) {
        String sql = "insert into member(user_name, user_last_name, birth_day, email, password) values(?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection(); //연결
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // valuse의 ?에 해당하는 값 설정
            pstmt.setString(1, member.getUserName());
            pstmt.setString(2, member.getUserLastName());
            if (member.getBirthDay() == null) {
                pstmt.setNull(3, Types.BIGINT);
            } else {
                pstmt.setLong(3, member.getBirthDay());
            }
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getPassword());
            pstmt.executeUpdate(); // SQL 문 실행
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<MemberDto> findById(Long id) {
        String sql = "select * from member where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                MemberDto member = new MemberDto();
                member.setId(rs.getLong("id"));
                member.setEmail(rs.getString("email"));
                return Optional.of(member);
            } else {
                return Optional.empty(); // 조회된 member가 없을 경우 empty Optional 반환
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }


    @Override
    public Optional<MemberDto> findByEmail(String email) {
        String sql = "select * from member where email = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                MemberDto member = new MemberDto();
                member.setId(rs.getLong("id"));
                member.setEmail(rs.getString("email"));
                return Optional.of(member);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    /**
     * 모든 멤버 반환
     *
     */
    @Override
    public List<MemberDto> findAll() {
        String sql = "select * from member";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<MemberDto> members = new ArrayList<>();
            while(rs.next()) {
                MemberDto member = new MemberDto();
                member.setId(rs.getLong("id"));
                member.setUserName(rs.getString("user_name"));
                member.setUserLastName(rs.getString("user_last_name"));
                member.setBirthDay(rs.getLong("birth_day"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("password"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }
    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }//데이터 베이스와 연결
    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//연결을 닫음
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
