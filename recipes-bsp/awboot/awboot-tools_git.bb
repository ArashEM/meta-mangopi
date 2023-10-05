SUMMARY = "AWboot tools"
HOMEPAGE = "https://github.com/szemzoa/awboot"

require awboot-common.inc

PROVIDES = "${MLPREFIX}awboot-mksunxi"
PROVIDES_class-native = "awboot-mksunxi-native"

PACKAGES += "${PN}-mksunxi"

EXTRA_OEMAKE_class-target = 'CROSS_COMPILE="${TARGET_PREFIX}" CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'
EXTRA_OEMAKE_class-native = 'CC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'
EXTRA_OEMAKE_class-nativesdk = 'CROSS_COMPILE="${HOST_PREFIX}" CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'

do_compile(){
    oe_runmake tools -C ${S} O=${B}
}

do_install () {
	install -d ${D}${bindir}

	# mksunxi
	install -m 0755 tools/mksunxi ${D}${bindir}/awboot-mksunxi
	ln -sf awboot-mksunxi ${D}${bindir}/mksunxi

}

ALLOW_EMPTY_${PN} = "1"
FILES_${PN} = ""
FILES_${PN}-mksunxi = "${bindir}/awboot-mksunxi ${bindir}/mksunxi"

BBCLASSEXTEND = "native nativesdk"
