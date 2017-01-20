DESCRIPTION = "Firmware for AP6212 WiFi (Broadcom SDIO device BCM43438)"
HOMEPAGE = ""
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e8c1458438ead3c34974bc0be3a03ed6"

PV = "7.10.226.49"

COMPATIBLE_MACHINE = "nanopi-neo"

S = "${WORKDIR}"

SRC_URI = " \
	https://github.com/igorpecovnik/lib/raw/9520fa24853b351a40c603167f61aeca2eebd18d/bin/firmware-overlay/ap6212/fw_bcm43438a0.bin;name=bin \
	https://github.com/igorpecovnik/lib/raw/9520fa24853b351a40c603167f61aeca2eebd18d/bin/firmware-overlay/ap6212/nvram.txt;name=txt \
	https://github.com/igorpecovnik/lib/raw/9520fa24853b351a40c603167f61aeca2eebd18d/LICENSE;name=lic \
"

SRC_URI[bin.md5sum] = "e20dff0eabdcd2b5b396f8a199775a4b"
SRC_URI[txt.md5sum] = "29030f406aa712ec2cd2c1c578273a46"
SRC_URI[lic.md5sum] = "e8c1458438ead3c34974bc0be3a03ed6"

FILES_${PN} = " \
	${base_libdir}/firmware/brcm/brcmfmac43430-sdio.bin \
	${base_libdir}/firmware/brcm/brcmfmac43430-sdio.txt \
"

do_install() {
	# rename to what the BRCM kernel driver wants
	mv	${S}/fw_bcm43438a0.bin	${S}/brcmfmac43430-sdio.bin
	mv	${S}/nvram.txt		${S}/brcmfmac43430-sdio.txt
	#
	install -d ${D}${base_libdir}/firmware/brcm
	install -m 0644 brcmfmac43430-sdio.bin	${D}${base_libdir}/firmware/brcm
	install -m 0644 brcmfmac43430-sdio.txt	${D}${base_libdir}/firmware/brcm
}
