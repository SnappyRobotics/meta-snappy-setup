export ROS_ROOT=/opt/ros/indigo 
export ROS_DISTRO=indigo 
export ROS_PACKAGE_PATH=/opt/ros/indigo/share 
export PATH=$PATH:/opt/ros/indigo/bin 
export LD_LIBRARY_PATH=/opt/ros/indigo/lib 
export PYTHONPATH=/opt/ros/indigo/lib/python2.7/site-packages 
export ROS_MASTER_URI=http://apalis-t30:11311
export CMAKE_PREFIX_PATH=/opt/ros/indigo 
touch /opt/ros/indigo/.catkin 


#To use roswtf 
export ROS_OS_OVERRIDE="ubuntu" 

#Sets ROS_IP
export ROS_IP="$(ifconfig | grep 'inet addr:'| grep -v '127.0.0.1' | cut -d: -f2 | awk '{ print $1}' | cut -d: -f1 | head -n 1 )"

