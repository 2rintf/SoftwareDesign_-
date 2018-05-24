# 图书管理系统_需求分析

##### 用户登录界面
系统运行后首先进入用户登录界面，用户登录的界面  
三个选项：**借阅人**、**柜台管理员**、**后台维护管理员**。  

---
### 一、图书馆柜台管理员功能
**主要功能：借阅控制界面、归还控制界面、欠款控制界面**
##### 用户登录界面
以柜台管理员身份登陆系统。
##### 借阅控制界面
使用时单击“借阅”按钮或直接按回车键，光标定位于“借阅人编码或姓名”项。  
1. 输入借阅人的证件号，点击“权限确认”，确认是否有权限进行借阅`（即是否有这个用户、是否存在超期图书、欠款是否超过20元）`，同时显示借阅人的借阅信息。
2. 确认有权限后，输入要借阅的图书编号，点击“确认借阅”，确认是否可借阅（馆藏总数量、剩余数量，**注：图书馆必须保证每一本书都有一本典藏本只供阅读，不允许外借**），若不能，则拒绝借阅；若允许，显示借阅详细信息：`借阅人、借阅图书及其编号、借阅日期、应归还日期、操作管理员`。“取消”可退出本次借阅。  
##### 归还控制界面
单击“还书”选项或直接按回车键，光标定位于“借阅人编码或姓名”项。  
1. 输入借阅图书的编号或者借阅人的证件号，查询是否有借阅信息，如果没有，给出提示；如果有，显示此条借阅信息的详细内容：`书名、图书编号、借阅人、借阅日期、应归还日期、是否超期（用红色字体标识）、欠款`。
2. 随后点击“确认还书”，重新显示借阅信息，完成还书。同时提供“缴纳欠款”按钮，进行欠款缴纳。  
##### 欠款控制界面
在同学要求缴纳欠款后，进行欠款清零。输入借阅人的证件号，`显示借阅情况、可借阅图书、欠款金额`。  
点击“缴纳欠款”进行清零。  

---
### 二、个人用户功能
**主要功能：借阅人的借阅信息查询、图书搜索、推荐购买图书**  
##### 借阅人的借阅信息查询
以用户身份登陆系统，点击“信息查询”，窗口将显示该人员的`当前借阅信息（图书名称、图书编码、借阅日期、应归还日期、是否欠款，注：红色标明催还图书）、欠款总额、可借阅图书、历史借阅信息`。如果系统中无该借阅人或该借阅人未借阅过任何图书，窗口将不显示任何信息。
##### 图书搜索
1. 按关键字搜索
2. 按分类进行搜索
>1.图书分布情况查询  
如果选择“图书分布查询”选项，则进入“图书分布查询”窗口，该窗口在初始状态下显示所有书目的摘要信息。  
2.按关键字查询  
如果选择“按关键字查询”选项，则进入“关键字查询”窗口。  
在初始状态下，该窗口显示所有书目的的摘要信息。如果要查看某本书的具体信息，双击该书摘要信息处。通过输入关键字，用户可以模糊查询，也可以精确查询。如果查询结果只有一本书，系统将直接显示该书的具体信息。实现精确查询时，系统将直接显示该书的具体信息。如果书库中无该书，则窗口中不显示任何信息。同时系统还支持多关键字查询。
##### 推荐购买图书
1. 点击“推荐购买”后，进入界面显示目前后台所有的`推荐书目信息、推荐日期、以及处理情况（未处理、已订购）`。
2. 点击“荐购”后，用户输入推荐购买的`图书名称或ISBN码、推荐理由`，点击“提交”完成。  

---
### 三、图书馆后台维护管理员功能
**主要功能：书库维护、借阅人信息维护、柜台管理员信息维护、默认还书期限设置界面、推荐购买图书维护**

##### 书库维护
书库维护包括**新书入库、查询显示、已有图书信息修改**  
1. 新书入库：添加`图书详细信息（名称、作者、出版社、ISBN码）、分类、入库图书数量`
2. 查询显示：现有馆藏图书的搜索（同借阅人的图书搜索）  
对书库进行任何修改后，系统执行退出时，**将查看数据库是否已被修改，然后提示用户是否保存修改并按用户要求进行相应操作**。
##### 借阅人信息维护
借阅人库是保存在本图书馆具有合法借书权限的人员。如果选择“借阅人库维护”选项，则进入该窗口。该窗口具有**增加、删除、查询、定位、修改权限及退出**等功能。
##### 柜台管理员信息维护
在窗口中，后台可以**创建和删除**柜台管理员的`编号及密码`，但无权修改它们。
##### 默认还书期限设置界面
选择“默认还书期限”选项后，打开窗口。默认还书期限**是以天数计**，修改并确认后，系统将按照设置填写借阅图书操作中的预期还书日期。（**只影响修改后的图书借阅**）
##### 推荐购买图书维护
点击“荐购图书维护”后，显示所有荐购图书信息：`荐购图书名称、ISBN码、推荐理由、推荐日期、处理情况（可以进行下拉菜单选择：未处理、已订购、拒绝）`。