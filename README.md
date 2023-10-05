# Introduction 
This is BSP layer for [Mangopi-MQ](https://mangopi.org/mangopi_mq) which uses _T113-S3_ SoC.

# Getting started
1. Clone required layers:
```bash
git clone git://git.yoctoproject.org/poky -b dunfell
cd poky/
git clone git://git.yoctoproject.org/meta-arm -b dunfell
git clone https://github.com/openembedded/meta-openembedded.git -b dunfell
git clone https://github.com/meta-qt5/meta-qt5.git -b dunfell
git clone https://github.com/ArashEM/meta-mangopi.git -b dunfell
cd ../
```
2. Export template configuraiton path and initialize build envrionment
```bash
export TEMPLATECONF=${TEMPLATECONF:-meta-mangopi/conf}
source poky/oe-init-build-env mangopi-mq
```
3. Start build process
```bash
bitbake qt5-image
bitback -c do_populate_sdk qt5-image
```
4. Flash `wic` image into your SD card
```bash
sudo dd if=tmp/deploy/images/mangopi-mq/qt5-image-mangopi-mq.wic of=/dev/sdX
```
5. Enjoy :-)

# View
Here is what it looks like (using 800x480 LCD)
![POKY](docs/poky.jpg)

# ToDo
1. LCD screen is not that stable. Some sort of flickering issue
2. LCD size is _800x480_ but `fbset -i` reports it's set to _720x480_. It can be fixed by `fbset -xres 800`. But I want to use full screen for boot splash

# More
I want to thanks all contributors of [AWboot](https://github.com/szemzoa/awboot). Their bootloader and kernel patches are directly used in this layer. 
