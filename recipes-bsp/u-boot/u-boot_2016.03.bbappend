DESCRIPTION="Upstream's U-boot configured for sunxi devices"

COMPATIBLE_MACHINE = "nanopi-neo"

DEFAULT_PREFERENCE_sun8i="1"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://git.denx.de/u-boot.git \
	file://boot.cmd \
	file://nanopi_neo_defconfig \
"
#	file://sun8i-h3-orangepi-one.dts \
#	file://uart_i2c.patch \
#

SRCREV = "29e0cfb4f77f7aa369136302cee14a91e22dca71"

do_configure_prepend() {
	cp ${WORKDIR}/nanopi_neo_defconfig ${WORKDIR}/git/configs/nanopi_neo_defconfig
	#cp ${WORKDIR}/sun8i-h3-orangepi-one.dts ${WORKDIR}/git/arch/arm/dts/sun8i-h3-orangepi-one.dts
}
