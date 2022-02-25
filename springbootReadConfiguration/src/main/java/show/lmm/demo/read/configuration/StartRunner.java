package show.lmm.demo.read.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import show.lmm.demo.read.configuration.core.conf.TestDataSizeYmlConf;
import show.lmm.demo.read.configuration.core.conf.TestDurationYmlConf;
import show.lmm.demo.read.configuration.core.conf.TestWeightYmlConf;

/**
 * 描述
 *
 * @author 刘明明
 * @since 2022-02-24 12:06
 */
@Component
public class StartRunner implements CommandLineRunner {

    @Autowired
    private TestDurationYmlConf testDurationYmlConf;
    @Autowired
    private TestDataSizeYmlConf testDataSizeYmlConf;
    @Autowired
    private TestWeightYmlConf testWeightYmlConf;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(String.format("时间周期-纳秒：%d", testDurationYmlConf.getDurationNs().getNano()));
        System.out.println(String.format("时间周期-微秒（转毫秒）：%d", testDurationYmlConf.getDurationUs().toMillis()));
        System.out.println(String.format("时间周期-毫秒：%d", testDurationYmlConf.getDurationMs().toMillis()));
        System.out.println(String.format("时间周期-秒：%d", testDurationYmlConf.getDurationS().getSeconds()));
        System.out.println(String.format("时间周期-分钟：%d", testDurationYmlConf.getDurationM().toMinutes()));
        System.out.println(String.format("时间周期-小时：%d", testDurationYmlConf.getDurationH().toHours()));
        System.out.println(String.format("时间周期-天：%d", testDurationYmlConf.getDurationD().toDays()));
        System.out.println("=========================================");
        System.out.println(String.format("转换期间-年：%d", testDurationYmlConf.getDurationPeriodY().getYears()));
        System.out.println(String.format("转换期间-月：%d", testDurationYmlConf.getDurationPeriodM().getMonths()));
        System.out.println(String.format("转换期间-周（转天）：%d", testDurationYmlConf.getDurationPeriodW().getDays()));
        System.out.println(String.format("转换期间-天：%d", testDurationYmlConf.getDurationPeriodD().getDays()));
        System.out.println("=========================================");
        System.out.println(String.format("文件大小-字节：%s", testDataSizeYmlConf.getFileSizeB().toBytes()));
        System.out.println(String.format("文件大小-k：%s", testDataSizeYmlConf.getFileSizeKB().toKilobytes()));
        System.out.println(String.format("文件大小-MB：%s", testDataSizeYmlConf.getFileSizeMB().toMegabytes()));
        System.out.println(String.format("文件大小-GB：%s", testDataSizeYmlConf.getFileSizeGB().toGigabytes()));
        System.out.println(String.format("文件大小-TB：%s", testDataSizeYmlConf.getFileSizeTB().toTerabytes()));
        System.out.println("=========================================");
        System.out.println(String.format("重量-吨：%s", testWeightYmlConf.getWeightT()));
        System.out.println(String.format("重量-千克：%s", testWeightYmlConf.getWeightKg()));
        System.out.println(String.format("重量-克：%s", testWeightYmlConf.getWeightG()));
        System.out.println(String.format("重量-毫克：%s", testWeightYmlConf.getWeightMG()));
    }
}
