SUMMARY = "Tiny FEL tools for allwinner SOC, support RISC-V D1 chip"
HOMEPAGE = "https://github.com/xboot/xfel"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig

DEPENDS += " libusb"
DEPENDS_class-native += " libusb-native"

EXTRA_OEMAKE_class-native = 'CC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'
EXTRA_OEMAKE_class-nativesdk = 'CROSS_COMPILE="${HOST_PREFIX}" CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'

SRC_URI = "https://github.com/xboot/xfel/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[md5sum] = "8329259c312f389aeab464eb9025ffcc"

do_install_class-nativesdk() {
    mkdir -p ${D}${prefix}
    export DESTDIR=${D}
    oe_runmake 'PREFIX=${prefix}' install
}

FILES_${PN}_append_class-nativesdk += " \
    ${prefix}/* \
    ${base_libdir_native}/* \
"

BBCLASSEXTEND = "native nativesdk"
