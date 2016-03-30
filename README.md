#bestpractice

## bestpractice-dao-service

把dao类和model类进行抽象和统一，简化dao层的代码编写，统一风格，通过使用mybatis的mapper类继承的方式来实现，因此推荐使用mybatis作为orm框架

## bestpractice-code-generate

用来根据create sql语句生成mapper.xml配置和model类，进一步减少代码的编写

### 启动和访问
* 启动：mvn jetty:run
* 访问：http://localhost:8081/mapper/showForm

### 操作步骤
只需要输入三个内容:
1. Mapper类的全名，比如：com.schoolcook.dao.mapper.UserMapper
2. Model类的类名：比如：User
3. 输入create sql，不包含主键、外键等，注意最后一个字段的末尾不能有逗号。比如：

```
CREATE TABLE `user` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '笑话的序号',
  `uid` bigint(20) unsigned NOT NULL COMMENT '文本笑话的唯一标识，根据context做md5得到',
  `context` blob NOT NULL COMMENT '笑话文本',
  `lmt` datetime NOT NULL COMMENT '最后修改时间'
)
```
4. 然后点击“submit”，就会在下面的文本框中生成mapper.xml
5. 把xml copy到eclipse的xml文件中进行格式化即可使用
