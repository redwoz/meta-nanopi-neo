FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI = " \
	git://git.denx.de/u-boot.git \
	file://fw_env.config \
"

SRCREV = "29e0cfb4f77f7aa369136302cee14a91e22dca71"

do_install_append() {
	# fw_env.config
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/fw_env.config	${D}${sysconfdir}
}
