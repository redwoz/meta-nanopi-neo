DESCRIPTION="Upstream's U-boot configured for sunxi devices"

COMPATIBLE_MACHINE = "nanopi-neo"

DEFAULT_PREFERENCE_sun8i="1"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://git.denx.de/u-boot.git \
	file://boot.cmd \
	file://clock_sun6i_fix.patch \
	file://U-Boot-sunxi-enable-H3-EMAC-for-the-nanopi-neo.patch \
"

SRCREV = "47895838a4fbe867ba9a170c6d1ea6a794095025"

do_configure_prepend() {
	echo "CONFIG_FS_EXT4=y" >> ${S}/configs/nanopi_neo_defconfig
}
