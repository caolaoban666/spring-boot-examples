import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.test.TransactionStart;
import com.test.entity.major.TbLabelRelation;
import com.test.service.ITbLabelRelationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author cyf
 * @description
 * @create 2019-05-28 12:04
 **/
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionStart.class)
public class LabelRelationTest {


    @Autowired
    private ITbLabelRelationService labelRelationService;

    @Test
    public void testSelectAll() {
        List<TbLabelRelation> tbLabelRelations =
                labelRelationService.selectList(null);
        System.out.println(tbLabelRelations.size());
    }


    @Test
    public void testInsert() {
        TbLabelRelation relation = new TbLabelRelation();
        relation.setLabelId("1");
        relation.setHisId("88888888");
        relation.setRelationId("");
//        relation.setCreateTime(LocalDateTime.now());
//        relation.setUpdateTime(LocalDateTime.now());
        relation.setDbId("111111111111111111111111");
        relation.setIdentityNo("");
        relation.setValidRange("");
        relation.setStatus("");
        relation.setCustom1("");
        relation.setCustom2("");
        boolean insert = labelRelationService.insert(relation);
        if (insert) {
            log.info("inset success!!!");
        }

    }


    @Test
    public void query() {

        Wrapper<TbLabelRelation> queryWrapper = new EntityWrapper<TbLabelRelation>();
        queryWrapper.eq("his_id", "0001257832");
        queryWrapper.eq("db_id", "f7ba4afaf8c54c28adfa6413ba0d88c7");
        queryWrapper.in("label_id","1,2");
//        queryWrapper.or("label_id","1","2");
//        labelRelationService.delete(queryWrapper);
        TbLabelRelation tbLabelRelation = labelRelationService.selectOne(queryWrapper);
        tbLabelRelation.setRelationId("");
        labelRelationService.updateById(tbLabelRelation);

    }


}
