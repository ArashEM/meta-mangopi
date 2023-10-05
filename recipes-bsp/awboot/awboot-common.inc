SECTION = "bootloaders"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "\
    file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS += " coreutils-native"

SRC_URI = "\
    git://github.com/szemzoa/awboot.git;protocol=https;branch=main \
"
SRCREV = "3159616daf10a3f33811f57e72ef5210ca0fe93c"

S = "${WORKDIR}/git"

