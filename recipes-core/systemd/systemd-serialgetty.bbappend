FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://usb-gadget-getty-ttyGS0.service \
"

do_install_append() {
    install -m 0644 ${WORKDIR}/usb-gadget-getty-ttyGS0.service ${D}${systemd_unitdir}/system/
    # enable the service
    ln -sf  ${systemd_unitdir}/system/usb-gadget-getty-ttyGS0.service \
            ${D}${sysconfdir}/systemd/system/getty.target.wants/usb-gadget-getty-ttyGS0.service
}
