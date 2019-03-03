package com.dao;

import com.entity.Post;
import com.utils.DBconn;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public int createPost(Post post){
        DBconn.init();
        String sql = "Insert into posts(title, content, create_date, author_id)Values(?,?,now(),?)";
        PreparedStatement pStatement = null;
        try {
            pStatement = DBconn.conn.prepareStatement(sql);
            pStatement.setObject(1, post.getTitle());
            pStatement.setObject(2, post.getContent());
            pStatement.setObject(3, post.getAuthorId());
            pStatement.executeUpdate();
            sql = "SELECT * FROM posts WHERE title=? and author_id=?";
            pStatement = DBconn.conn.prepareStatement(sql);
            pStatement.setObject(1, post.getTitle());
            pStatement.setObject(2, post.getAuthorId());
            ResultSet resultSet = pStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("post_id");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List getAllPosts(int userId){
        DBconn.init();
        try {
            String sql = "Select * from posts Where author_id=?";
            PreparedStatement pStatement = DBconn.conn.prepareStatement(sql);
            pStatement.setObject(1, userId);
            ResultSet rS = pStatement.executeQuery();
            List<Post> allPosts = new ArrayList<>();
            int postId, authorId, visitors;
            String title, content;
            Date createDate;
            while (rS.next()){
                postId = rS.getInt("post_id");
                title = rS.getString("title");
                Post post = new Post(title, "", -1);
                post.setPostId(postId);
                allPosts.add(post);
            }
            return allPosts;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Post getPost(int postId){
        DBconn.init();
        try {
            String sql = "update posts set visitors=visitors+1 where post_id=?";
            PreparedStatement pS = DBconn.conn.prepareStatement(sql);
            pS.setObject(1, postId);
            pS.executeUpdate();
            sql = "SELECT * FROM posts WHERE post_id=?";
            pS = DBconn.conn.prepareStatement(sql);
            pS.setObject(1, postId);
            ResultSet rS = pS.executeQuery();
            if(rS.next()){
                Post post = new Post(rS.getString("title"), rS.getString("content"), rS.getInt("author_id"));
                post.setCreateDate(rS.getDate("create_date"));
                post.setPostId(postId);
                post.setVisitors(rS.getInt("visitors"));
                return post;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
