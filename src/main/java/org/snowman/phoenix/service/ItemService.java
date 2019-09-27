package org.snowman.phoenix.service;

import io.github.snowthinker.Id.SnowFlaker;
import io.github.snowthinker.mh.MybatisSqlHelper;
import io.github.snowthinker.model.PojoHelper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.snowman.phoenix.entity.Item;
import org.snowman.phoenix.mapper.PhoenixBatchMapper;
import org.snowman.phoenix.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SnowFlaker snowFlaker;

    @Autowired
    private PhoenixBatchMapper phoenixBatchMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void batchAdd() {
        int batchSize = 100;

        SqlSession sqlSession = sqlSessionFactory.openSession();
        for(int batch=0; batch<100; batch++) {

            List<String> sqlList = new ArrayList<>();
            for(int idx = 0; idx < batchSize; idx++) {
                Item item = new Item(snowFlaker.nextId(), String.valueOf(snowFlaker.nextId()), "商品名称", 10000000L, 1, 2, "华为", "京东亚洲1号仓");

                String sql = MybatisSqlHelper.getMapperSql(sqlSession, "org.snowman.phoenix.mapper.ItemMapper.save", PojoHelper.convertPojo2Map(item));
                sqlList.add(sql);
            }

            phoenixBatchMapper.batchSave(sqlList);
        }
    }
}
