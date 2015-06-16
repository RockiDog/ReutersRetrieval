# ReutersRetrieval

- 实现倒排索引以及向量空间模型，支持评分、排序及Top K查询

- 推荐添加功能，最终将按照添加功能的强弱适当加分（如布尔查询，短语查询，同义词查询，拼写矫正，索引压缩等本课程提到的知识点）

##TODO

- 添加布尔查询功能，制定一种科学的term 定义方法解决短语的问题（例如查询New York AND Beijing，索引生成时如何保证New York 作为一个词条保存在索引中，参考Slide IR03 P25 - P33）

- 添加词项归一化功能（参考Slide IR03 P13 - P19），最好不限于老师给的算法，如果可以的话找一个比较科学的算法

- 索引的编码、译码和文件存取，采用VB 码或者γ 码，可以加上分块存储，Slide IR06 里的策略都可以添加

##Due

周四上课前
