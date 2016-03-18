#!/usr/bin/env bash

set -x

for i in $(find "work-4" | grep txt)
do
    iconv -f EUCKR -t UTF-8 $i > work-4-utf8/${i:7:4}-${i:12}
done

