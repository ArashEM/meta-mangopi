# Make initramfs compatible with ARM
INITRAMFS_SCRIPTS_remove = "\
    initramfs-module-setup-live \
    initramfs-module-install \
    initramfs-module-install-efi \
"

INITRAMFS_SCRIPTS_append = "\
    initramfs-module-nfsrootfs \
    initramfs-module-ecm \
"
