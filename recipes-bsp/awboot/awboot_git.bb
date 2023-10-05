SUMMARY = "small linux bootloader for Allwinner T113-S3"
HOMEPAGE = "https://github.com/szemzoa/awboot"

PROVIDES = "virtual/bootloader"
DEPENDS += "awboot-tools-native gcc-arm-none-eabi-native"

require awboot-common.inc
inherit deploy

SRC_URI += " \
    file://0001-fix-makefile-path.patch \
    file://0002-disable-fs-cache.patch \
"

AWBOOT_BINARY = "awboot-boot-sd.bin"

do_compile() {
    unset LDFLAGS
	unset CFLAGS
	unset CPPFLAGS
    oe_runmake -C ${S} O=${B} all
}

do_install(){
    install -D -m 644 ${B}/${AWBOOT_BINARY} ${D}/boot/${AWBOOT_BINARY}
}

do_deploy() {
    install -D -m 644 ${B}/${AWBOOT_BINARY} ${DEPLOYDIR}/${AWBOOT_BINARY}-${PV}-${PR}
    cd ${DEPLOYDIR}
    ln -sf ${AWBOOT_BINARY}-${PV}-${PR} ${AWBOOT_BINARY}
}

FILES_${PN} = "/boot"

addtask deploy before do_build after do_compile
