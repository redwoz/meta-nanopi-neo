COMPATIBLE_MACHINE = "nanopi-neo"

FILESEXTRAPATHS_append := ":${THISDIR}/files"

SRC_URI += "file://xunlong_orange_pi_pc.fex"

do_compile_prepend() {
    cp "${S}/../${SUNXI_FEX_FILE}" "${S}/${SUNXI_FEX_FILE}"
}

