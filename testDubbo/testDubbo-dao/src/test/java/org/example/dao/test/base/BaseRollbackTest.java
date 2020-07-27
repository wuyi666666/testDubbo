package org.example.dao.test.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 执行单元测试时，数据不会入库，测试完毕数据自动回滚
 * @author 698533
 *
 */
@ContextConfiguration(locations = "classpath*:test-dao.xml")
public class BaseRollbackTest extends AbstractTransactionalJUnit4SpringContextTests{

}
