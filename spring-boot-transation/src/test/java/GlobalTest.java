import com.test.TransactionStart;
import com.test.entity.major.TbLabelFormRelation;
import com.test.service.ITbLabelFormRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionStart.class)
public class GlobalTest {

	@Autowired
	private ITbLabelFormRelationService formRelationService;

	/**
	 * springboot 整合事物，测试方法
	 *
	 *
	 * 1. 开启注解事物
	 *
	 * ① 启动类上增加注解  @EnableTransactionManagement
	 * ② 需要添加事物的业务方法上添加注解 @Transactional(rollbackFor = RuntimeException.class)
	 * ③ 必须在service 层，必须为public 修饰，必须抛出异常
	 *
	 */

	@Test
	public void testList() {
		formRelationService.delLabelForm("1");
	}


	@Autowired
	private ITbLabelFormRelationService relation;

	@Test
	public void testQuery(){
		TbLabelFormRelation relations = this.relation.selectById(1);
		System.out.println(relations);
	}


}
