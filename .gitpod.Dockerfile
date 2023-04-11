FROM gitpod/workspace-full:2023-03-24-22-45-37

RUN wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz

RUN sudo tar zxf jdk-17_linux-x64_bin.tar.gz --directory /opt/

RUN echo 'export JAVA_HOME=/opt/jdk-17_linux-x64_bin/' >> /home/gitpod/.bashrc

RUN echo 'export PATH=/opt/jdk-17_linux-x64_bin/bin:$PATH' >> /home/gitpod/.bashrc