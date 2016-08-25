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

DEFAULT_PREFERENCE = "-1"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

PV = "4.7+4.8rc1.git${SRCPV}"
SRCREV_pn-${PN} = "f61e4c2adf12d423a26aa0374bc1eb0e84536cda"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_append := ":${THISDIR}/files"
FILESEXTRAPATHS_append := ":${THISDIR}/files-megous48"

# file://dts.patch
# file://dtsi.patch

SRC_URI = "git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.8 \
	file://dtsi.patch \
	file://dts.patch \
	\
	file://defconfig \
	file://sun8i_emac.cfg \
	file://i2c.cfg \
	file://ths.cfg \
"

do_install_prepend() {
}

do_configure_append() {
	# cp ${WORKDIR}/nanopi-neo.dts ${WORKDIR}/git/arch/arm/boot/dts/sun8i-h3-orangepi-one.dts
}

