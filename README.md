#bestpractice

## bestpractice-code-generate

��������mapper.xml�ļ�

### �����ͷ���
* ������mvn jetty:run
* ���ʣ�http://localhost:8081/mapper/showForm

### ��������
ֻ��Ҫ������������:
1. Mapper���ȫ�������磺com.schoolcook.dao.mapper.UserMapper
2. Model������������磺User
3. ����create sql������������������ȣ�ע�����һ���ֶε�ĩβ�����ж��š����磺

```
CREATE TABLE `user` (
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Ц�������',
  `uid` bigint(20) unsigned NOT NULL COMMENT '�ı�Ц����Ψһ��ʶ������context��md5�õ�',
  `context` blob NOT NULL COMMENT 'Ц���ı�',
  `lmt` datetime NOT NULL COMMENT '����޸�ʱ��'
)
```
4. Ȼ������submit�����ͻ���������ı���������mapper.xml
5. ��xml copy��eclipse��xml�ļ��н��и�ʽ������ʹ��