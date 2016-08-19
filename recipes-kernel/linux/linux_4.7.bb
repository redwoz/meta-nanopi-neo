SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|nanopi-neo)"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# http://lists.openembedded.org/pipermail/openembedded-core/2015-May/104616.html
KCONFIG_MODE="--alldefconfig"

DEFAULT_PREFERENCE = "1"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
	
# 4.8rc1 = 29b4817d4018df78086157ea3a55c1d9424a7cfc
# 4.8rc1 w/EMAC v3 = 6b191b84413ee715c0489a59b142a0f047818aef

PV = "4.7+4.8rc1.git${SRCPV}"
SRCREV_pn-${PN} = "6b191b84413ee715c0489a59b142a0f047818aef"

S = "${WORKDIR}/git"

# SRC_URI += "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;branch=master \
#         file://defconfig \
#         "

SRC_URI = "git://github.com/montjoie/linux.git;protocol=git;branch=sun8i-emac-wip-v3 \
	file://sun8i-h3-orangepi-one.dts \
	file://defconfig \
	file://sun8i_emac.cfg \
	file://ths.cfg \
	file://i2c.cfg \
"

do_install_prepend() {
	cp ${WORKDIR}/sun8i-h3-orangepi-one.dts ${WORKDIR}/git/arch/arm/boot/dts/sun8i-h3-orangepi-one.dts
}

