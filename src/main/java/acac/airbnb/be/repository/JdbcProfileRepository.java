package acac.airbnb.be.repository;

import acac.airbnb.be.domain.ProfileDto;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcProfileRepository implements ProfileRepository {

    private final DataSource dataSource;

    public JdbcProfileRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<ProfileDto> findById(Long id) {
        String sql = "select * from profile where id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                ProfileDto profileDto = new ProfileDto();
                profileDto.setId(rs.getLong("id"));
                profileDto.setUserName(rs.getString("user_name"));
                profileDto.setReviewNumber(rs.getInt("review_number"));
                profileDto.setYears(rs.getInt("years"));
                profileDto.setHobby(rs.getString("hobby"));
                profileDto.setCountry(rs.getString("country"));
                profileDto.setFirstReview(rs.getString("first_review"));
                profileDto.setSecondReview(rs.getString("second_review"));
                return Optional.of(profileDto);
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
    public List<ProfileDto> findAll() {
        String sql = "select * from profile";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<ProfileDto> profiles = new ArrayList<>();
            while(rs.next()) {
                ProfileDto profile = new ProfileDto();
                profile.setId(rs.getLong("id"));
                profile.setUserName(rs.getString("user_name"));
                profile.setReviewNumber(rs.getInt("review_number"));
                profile.setYears(rs.getInt("years"));
                profile.setHobby(rs.getString("hobby"));
                profile.setCountry(rs.getString("country"));
                profile.setFirstReview(rs.getString("first_review"));
                profile.setSecondReview(rs.getString("second_review"));
                profiles.add(profile);
            }
            return profiles;
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
