DESCRIPTION="Upstream's U-boot configured for sunxi devices"

COMPATIBLE_MACHINE = "nanopi-neo"

DEFAULT_PREFERENCE_sun8i="1"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://git.denx.de/u-boot.git \
	file://boot.cmd \
	file://clock_sun6i_fix.patch \
"

SRCREV = "29e0cfb4f77f7aa369136302cee14a91e22dca71"

do_configure_prepend() {
}
