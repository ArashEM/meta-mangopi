SUMMARY = "Driver for RTL8189FTV WiFi interface"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

DEPENDS += "bc-native"

SRC_URI = " \
        git://github.com/jwrdegoede/rtl8189ES_linux.git;protocol=https;branch=rtl8189fs \
        file://001-remove-depmod-from-install-rule.patch \
"
SRCREV = "75a566a830037c7d1309c5a9fe411562772a1cf2"

S = "${WORKDIR}/git"

RPROVIDES_${PN} += "kernel-module-8189fs"

EXTRA_OEMAKE += " KSRC=${STAGING_KERNEL_DIR}"
MODULES_INSTALL_TARGET = "install"

do_install_prepend(){
    mkdir -p ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    export MODDESTDIR="${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/"
}
