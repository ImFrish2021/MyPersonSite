package xyz.frish2021.website.Controller;


import com.youbenzi.md2.util.MDUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import xyz.frish2021.website.util.FileUtil;

import java.io.File;

@Controller
public class indexController {
    @Inject("${website.website_icon}")
    String website_icon;
    @Inject("${website.headshot}")
    String headshot;
    @Inject("${website.mail}")
    String mail;
    @Inject("${website.bilibili}")
    String bilibili;
    @Inject("${website.github}")
    String github;
    @Inject("${website.gitee}")
    String gitee;

    @Mapping("/")
    public ModelAndView index() {
        String html = "";
        if (FileUtil.readFile(new File(System.getProperty("user.dir"), "article/article.md")).isEmpty()) {
            html = MDUtil.markdown2Html("# Hello World");
        } else {
            html = MDUtil.markdown2Html(FileUtil.readFile(new File(System.getProperty("user.dir"), "article/article.md")));
        }
        return new ModelAndView("/index.html").put("website_icon", "/local/" + website_icon).put("headshot", "/local/" + headshot).put("article", html).put("mail", "mailto:" + mail).put("bilibili", "https://space.bilibili.com/" + bilibili).put("gitee", "https://www.gitee.com/" + gitee).put("github", "https://github.com/" + github);
    }
}
