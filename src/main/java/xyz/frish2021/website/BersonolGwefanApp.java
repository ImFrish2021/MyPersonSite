package xyz.frish2021.website;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.core.util.LogUtil;
import org.noear.solon.logging.utils.LogUtilToSlf4j;
import org.noear.solon.web.staticfiles.StaticMappings;
import org.noear.solon.web.staticfiles.StaticRepository;
import org.noear.solon.web.staticfiles.repository.FileStaticRepository;

import java.io.File;

@SolonMain
public class BersonolGwefanApp extends Solon {

    // 主程序主要入口
    public static void main(String[] args) {
        start((BersonolGwefanApp.class), (args), (app) -> {
            // 这是Solon App的程序主要接口
            StaticRepository staticRepository = new FileStaticRepository(new File(System.getProperty("user.dir")).getAbsolutePath());
            StaticMappings.add("/local/", staticRepository);
        });
    }

}