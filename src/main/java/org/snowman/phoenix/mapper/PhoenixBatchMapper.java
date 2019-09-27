package org.snowman.phoenix.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
@Slf4j
public class PhoenixBatchMapper {

    private static final String DRIVER_CLASS = "";

    private String hbaseUrl;

    public void batchSave(List<String> sqlList) {
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(hbaseUrl);
            stmt = conn.createStatement();

            for(String sql : sqlList) {
                stmt.executeUpdate(sql);
            }
            conn.commit();
        } catch(Exception e) {
            log.error("batchSave error: {}", e);
        } finally{
            if(null != stmt) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    log.error("Close stmt error: {}", e);
                }
            }
            if(null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error("Close conn error: {}", e);
                }
            }
        }
    }
}
