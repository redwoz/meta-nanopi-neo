DESCRIPTION="Upstream's U-boot configured for sunxi devices"

COMPATIBLE_MACHINE = "nanopi-neo"

DEFAULT_PREFERENCE_sun8i="1"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=mirror/next \
	file://boot.cmd \
	file://nanopi_neo_defconfig \
	file://sun8i-h3-orangepi-one.dts \
"

SRCREV = "fcada3b05e56c9b22bf5f92ba94fa80449452e76"

do_configure_prepend() {
	cp ${WORKDIR}/nanopi_neo_defconfig ${WORKDIR}/git/configs/nanopi_neo_defconfig
	cp ${WORKDIR}/sun8i-h3-orangepi-one.dts ${WORKDIR}/git/arch/arm/dts/sun8i-h3-orangepi-pc.dts
}
