
#!/bin/bash


echo "Provisioning virtual machine..."
  
apt-get update -y
  
apt-get upgrade -y



echo "Install git..."
  
apt-get install git -y > /dev/null
  
git --version



echo "Install java..."
  
apt-get install openjdk-8-jdk -y > /dev/null
  
java -version



echo "Install unzip..."
  
apt-get install unzip -y > /dev/null
  
unzip -v



echo "Install maven..."
  
apt-cache search maven
  
apt-get install maven -y > /dev/null
  
mvn -v



echo "Install sshpass..."
  
apt-get install sshpass -y > /dev/null
  
sshpass



echo "Install Jenkins..."
  
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -
  sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'
  
apt-get update
  
apt-get install jenkins -y > /dev/null
  
echo "starting jenkins..."
  
service jenkins status