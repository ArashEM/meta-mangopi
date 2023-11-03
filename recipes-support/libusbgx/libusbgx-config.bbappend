FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://mangopi-mq.schema \
"

do_install_append() {
    install -Dm 0644 ${WORKDIR}/mangopi-mq.schema ${D}${sysconfdir}/usbgx/mangopi-mq.schema
}
