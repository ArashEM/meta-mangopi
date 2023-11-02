DESCRIPTION = "Qt5 image for Mangopi-MQ board(T113)"

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    "

inherit core-image
inherit populate_sdk_qt5


QT_TOOLS = " \
    qtbase \
    qtbase-plugins \
    qtserialport \
"

FONTS = " \
    fontconfig \
    fontconfig-utils \
    liberation-fonts \
"

QT_DEV_TOOLS = " \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtquickcontrols-qmlplugins \
    qtgraphicaleffects \
    qtquickcontrols-plugins \
"

QT_EXAMPLE = " \
    quitindicators \
    qt-simple-calc \
    cinematicexperience \
    qt5everywheredemo \
    qt5ledscreen \
    qtsmarthome \
    quitbattery \
"

FB_TOOLS = " \
    fb-test \
    fbset-modes \
    fbset \
    libdrm-tests \
"

WIFI_TOOLS = " \
    kernel-modules \
    rtl8189ftv \
    wpa-supplicant \
"

MISC_TOOLS += " \
    can-utils \
    libsocketcan \
    strace \
    vim \
    htop \
    lsof \
    e2fsprogs-resize2fs \
    os-release \
    lsb-release \
    usbutils \
    libusbgx \
"

TSLIB = " \
    tslib \
    tslib-calibrate \
    tslib-conf \
    tslib-dev \
    tslib-tests \
"

IMAGE_INSTALL += " \
    ${QT_DEV_TOOLS} \
    ${QT_TOOLS} \
    ${QT_EXAMPLE} \
    ${FONTS} \
    ${TSLIB} \
    ${WIFI_TOOLS} \
    ${FB_TOOLS} \
    ${MISC_TOOLS} \
"

set_8189fs_loglevel(){
    mkdir -p ${IMAGE_ROOTFS}/etc/modprobe.d
    echo 'options 8189fs rtw_drv_log_level=1' > ${IMAGE_ROOTFS}/etc/modprobe.d/8189fs.conf
}

ROOTFS_POSTPROCESS_COMMAND += "set_8189fs_loglevel;"
