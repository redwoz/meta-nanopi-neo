if test -z "${mmcpart}"; then setenv mmcpart 1; saveenv; fi;
setenv bootargs console=${console} root=/dev/mmcblk0p${mmcpart} rootwait panic=10 ${extra}
load mmc 0:1 ${fdt_addr_r} boot/${fdtfile}
load mmc 0:1 ${kernel_addr_r} boot/uImage
bootm ${kernel_addr_r} - ${fdt_addr_r}

