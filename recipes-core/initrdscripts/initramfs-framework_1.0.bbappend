FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://ecm \
"

do_install_append() {
    # ecm function
    install -m 0755 ${WORKDIR}/ecm ${D}/init.d/98-ecm
}

PACKAGES += "\
    initramfs-module-ecm \
"

SUMMARY_initramfs-module-ecm = "enable USB ethernet function in initramfs"
RDEPENDS_initramfs-module-ecm = "${PN}-base"
FILES_initramfs-module-ecm = "/init.d/98-ecm"
