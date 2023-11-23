SUMMARY = "Tiny FEL tools for allwinner SOC, support RISC-V D1 chip"
HOMEPAGE = "https://github.com/xboot/xfel"
SECTION = "console/utils"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pkgconfig native

DEPENDS += "libusb-native"
SRC_URI = "https://github.com/xboot/xfel/archive/refs/tags/v${PV}.tar.gz"
SRC_URI[md5sum] = "8329259c312f389aeab464eb9025ffcc"

BBCLASSEXTEND = "nativesdk"
