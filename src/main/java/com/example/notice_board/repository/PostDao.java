package com.example.notice_board.repository;

import com.example.notice_board.domain.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PostDao {
    private final JdbcTemplate jdbctemplate;

    public PostDao(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public void add(Post post) { //글 작성 기능
        String sql = "INSERT INTO board_posts (title, writer, password, content, created_at) VALUES (?, ?, ?, ?, ?)";
        jdbctemplate.update(sql, post.getTitle(), post.getWriter(), post.getPassword(), post.getContent(), LocalDateTime.now());
    }


    public List<Post> findAll() { //글 전체 조회
        String sql = "SELECT * FROM board_posts";
        return jdbctemplate.query(sql, new RowMapper<Post>() {
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post post = new Post();
                post.setId(BigInteger.valueOf(rs.getLong("id")));
                post.setTitle(rs.getString("title"));
                post.setWriter(rs.getString("writer"));
                post.setPassword(rs.getString("password"));
                post.setContent(rs.getString("content"));
                post.setCreated_at(Timestamp.valueOf(rs.getTimestamp("created_at").toLocalDateTime()));
                return post;
            }
        });
    }

    public Post findById(Long id) { //id로 글 조회
        String sql = "SELECT * FROM board_posts WHERE id = ?";
        return jdbctemplate.queryForObject(sql, new RowMapper<Post>() {
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post post = new Post();
                post.setId(BigInteger.valueOf(rs.getLong("id")));
                post.setTitle(rs.getString("title"));
                post.setWriter(rs.getString("writer"));
                post.setPassword(rs.getString("password"));
                post.setContent(rs.getString("content"));
                post.setCreated_at(Timestamp.valueOf(rs.getTimestamp("created_at").toLocalDateTime()));
                return post;
            }
        }, id);
    }

    public void update(Post post) {
        String sql = "UPDATE board_posts SET title = ?, content = ? WHERE id = ? AND password = ?";
        jdbctemplate.update(sql, post.getTitle(), post.getContent(), post.getId(), post.getPassword());
    }

    public void delete(Long id, String password) {
        String sql = "DELETE FROM board_posts WHERE id = ? AND password = ?";
        jdbctemplate.update(sql, id, password);
    }
}
