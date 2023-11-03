DESCRIPTION = "Linux Kernel from Tarball"
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI = "\
    https://cdn.kernel.org/pub/linux/kernel/v6.x/linux-${PV}.tar.xz \
    file://001-second_core_support_in_platsmp.patch \
    file://002-add-mangopi-dual-dtb.patch \
    file://defconfig \
    "
SRC_URI[sha256sum] = "8cf10379f7df8ea731e09bff3d0827414e4b643dd41dc99d0af339669646ef95"

LINUX_VERSION ?= "${PV}"
LINUX_VERSION_EXTENSION_append = "-custom"

S = "${WORKDIR}/linux-${PV}"
COMPATIBLE_MACHINE = "sun8i"
