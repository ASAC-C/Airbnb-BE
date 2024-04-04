package acac.airbnb.be.repository;

import acac.airbnb.be.domain.MemberDto;

import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class JdbcMemberRepository implements  MemberRepository{
    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 회원 정보를 저장
     * sql문을 통해 value들을 주입 시킴
     */
    @Override
    public MemberDto save(MemberDto memberDto) {
        String sql = "insert into member(user_name, user_last_name, birth_day, email, password) values(?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, memberDto.getUserName());
            pstmt.setString(2, memberDto.getUserLastName());
            if (memberDto.getBirthDay() == null) {
                pstmt.setNull(3, Types.BIGINT);
            } else {
                pstmt.setLong(3, memberDto.getBirthDay());
            }
            pstmt.setString(4, memberDto.getEmail());
            pstmt.setString(5, memberDto.getPassword());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                memberDto.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return memberDto;
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
                MemberDto memberDto = new MemberDto();
                memberDto.setId(rs.getLong("id"));
                memberDto.setEmail(rs.getString("email"));
                return Optional.of(memberDto);
            } else {
                return Optional.empty();
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
                MemberDto memberDto = new MemberDto();
                memberDto.setId(rs.getLong("id"));
                memberDto.setEmail(rs.getString("email"));
                return Optional.of(memberDto);
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
            List<MemberDto> memberDtos = new ArrayList<>();
            while(rs.next()) {
                MemberDto memberDto = new MemberDto();
                memberDto.setId(rs.getLong("id"));
                memberDto.setUserName(rs.getString("user_name"));
                memberDto.setUserLastName(rs.getString("user_last_name"));
                memberDto.setBirthDay(rs.getLong("birth_day"));
                memberDto.setEmail(rs.getString("email"));
                memberDto.setPassword(rs.getString("password"));
                memberDtos.add(memberDto);
            }
            return memberDtos;
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
