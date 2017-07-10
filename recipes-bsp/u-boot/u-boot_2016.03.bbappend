DESCRIPTION="Upstream's U-boot configured for sunxi devices"

COMPATIBLE_MACHINE = "nanopi-neo"

DEFAULT_PREFERENCE_sun8i="1"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://git.denx.de/u-boot.git \
	file://boot.cmd \
	file://h3-Fix-PLL1-setup-to-never-use-dividers.patch \
	file://U-Boot-v2-sunxi-add-NanoPi-NEO-Air-defconfig.patch \
	file://U-Boot-sunxi-enable-H3-EMAC-for-the-nanopi-neo-air.patch \
"

# SRCREV = "47895838a4fbe867ba9a170c6d1ea6a794095025"
SRCREV = "ee6fb217cbf3e81cd2c5f1a13f989cf59016781f"

FILES_${PN} += " \
	/boot/boot.scr \
	/boot/u-boot-sunxi-with-spl.bin \
"

do_configure_prepend() {
	echo "CONFIG_FS_EXT4=y" >> ${S}/configs/nanopi_neo_air_defconfig
	echo "CONFIG_SUN8I_EMAC=y" >> ${S}/configs/nanopi_neo_air_defconfig
}

