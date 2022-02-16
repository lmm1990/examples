package show.lmm.demo.multi.datasource.core.conf.dataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import show.lmm.demo.multi.datasource.core.constant.TransactionManagerConstant;

import javax.sql.DataSource;

/**
 * md_crebas数据源
 *
 * @author 刘明明
 * @date 2021-10-18 15:52:42
 */
@Configuration
@MapperScan(basePackages = "show.lmm.demo.**.mapper.b",
        sqlSessionFactoryRef = "bSqlSessionFactory")
public class BDataSourceConfig extends BaseDataSourceConfig {

    /**
     * @Bean 注册Bean对象
     * @Primary 表示默认数据源
     * @ConfigurationProperties 读取properties中的配置参数映射成为一个对象
     */
    @Override
    @Bean(name = "bDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.b")
    public HikariDataSource getDateSource() {
        return new HikariDataSource();
    }

    /**
     * @param dataSource 数据源
     * @return SqlSessionFactory
     * @Primary 默认SqlSessionFactory
     */
    @Override
    @Bean(name = "bSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("bDataSource") DataSource dataSource) throws Exception {
        return getSqlSessionFactory(dataSource, "classpath*:mapper/b/*.xml").getObject();
    }

    @Override
    @Bean("bSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("bSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * b数据源事务管理器
     *
     * @param dataSource:  数据源
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @since 刘明明/2022-02-16 15:10:50
     **/
    @Bean(name = TransactionManagerConstant.B_TRANSACTION_MANAGER)
    @Override
    public DataSourceTransactionManager transactionManager(@Qualifier("bDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
