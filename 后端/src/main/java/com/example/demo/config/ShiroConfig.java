package com.example.demo.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author sgl
 * @Date 2018-06-11 17:23
 */
@Configuration
public class ShiroConfig {


    /**
     * 凭证匹配器
     *
     * @return
     */


    /**
     * 自定义realm
     *
     * @return
     */
    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }


    /**
     * 设置过滤规则
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/LoginController/NoLogin");

//        未授权 默认到此url
//        shiroFilterFactoryBean.setUnauthorizedUrl("/testController/no");

        //注意此处使用的是LinkedHashMap，是有顺序的，shiro会按从上到下的顺序匹配验证，匹配了就不再继续验证
        //所以上面的url要苛刻，宽松的url要放在下面，尤其是"/**"要放到最下面，如果放前面的话其后的验证规则就没作用了。


//        过滤器名称	过滤器类	描述
//        anon	org.apache.shiro.web.filter.authc.AnonymousFilter	匿名过滤器
//        authc	org.apache.shiro.web.filter.authc.FormAuthenticationFilter	如果继续操作，需要做对应的表单验证否则不能通过
//        authcBasic	org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter	基本http验证过滤，如果不通过，跳转屋登录页面
//        logout	org.apache.shiro.web.filter.authc.LogoutFilter	登录退出过滤器
//        noSessionCreation	org.apache.shiro.web.filter.session.NoSessionCreationFilter	没有session创建过滤器
//        perms	org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter	权限过滤器
//        port	org.apache.shiro.web.filter.authz.PortFilter	端口过滤器，可以设置是否是指定端口如果不是跳转到登录页面
//        rest	org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter	http方法过滤器，可以指定如post不能进行访问等
//        roles	org.apache.shiro.web.filter.authz.RolesAuthorizationFilter	角色过滤器，判断当前用户是否指定角色
//        ssl	org.apache.shiro.web.filter.authz.SslFilter	请求需要通过ssl，如果不是跳转回登录页
//        user	org.apache.shiro.web.filter.authc.UserFilter	如果访问一个已知用户，比如记住我功能，走这个过滤器

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
                filterChainDefinitionMap.put("/LoginController/*","anon");
        filterChainDefinitionMap.put("/EnRollController/*","anon");

//
////        注意：当授权拦截后，shiro会自动跳转到未授权页面
        filterChainDefinitionMap.put("/CourseController/*","authc");
        filterChainDefinitionMap.put("/CourseStudentController/*","authc");
        filterChainDefinitionMap.put("/CourseTeacherController/*","authc");
        filterChainDefinitionMap.put("/StudentController/*","authc");
        filterChainDefinitionMap.put("/TeacherController/*","authc");
        filterChainDefinitionMap.put("/WorkController/*","authc");
        filterChainDefinitionMap.put("/WorkStudentController/*","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

//    配置shirodialect  配合thymeleaf和 shiro标签使用
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }



}
