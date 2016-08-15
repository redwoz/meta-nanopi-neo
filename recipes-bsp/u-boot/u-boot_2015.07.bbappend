COMPATIBLE_MACHINE = "nanopi-neo"

SRC_URI = "git://github.com/linux-sunxi/u-boot-sunxi.git;protocol=git;branch=mirror/next"
SRCREV = "fcada3b05e56c9b22bf5f92ba94fa80449452e76"

FILESEXTRAPATHS_append := ":${THISDIR}/files"
SRC_URI += " \
	file://boot.cmd \
	file://nanopi_neo_defconfig \
"

do_configure_prepend() {
	cp ${WORKDIR}/nanopi_neo_defconfig ${WORKDIR}/git/configs/nanopi_neo_defconfig
}

