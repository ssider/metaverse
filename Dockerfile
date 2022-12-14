# 基础镜像
FROM  java:8
# author
MAINTAINER zmx

EXPOSE 8080

# 挂载目录
VOLUME /home/ruoyi
# 创建目录
RUN mkdir -p /home/ruoyi
# 指定路径
WORKDIR /home/ruoyi
# 复制jar文件到路径
COPY ruoyi-admin.jar /home/ruoyi/ruoyi-admin.jar
# 启动认证服务
ENTRYPOINT ["java","-jar","ruoyi-admin.jar"]
