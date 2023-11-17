FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://can0.network \
    file://usb0.network \
    file://wlan0.network \
"

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/can0.network \
    ${sysconfdir}/systemd/network/usb0.network \
    ${sysconfdir}/systemd/network/wlan0.network \
"

do_install_append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/can0.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/usb0.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan0.network ${D}${sysconfdir}/systemd/network
}
