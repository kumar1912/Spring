package com.tui.uk.domain;

import java.util.Comparator;

public class PrintContarctComparator implements Comparator<PrintContractDetails> {

	@Override
	public int compare(PrintContractDetails printContractDetails1, PrintContractDetails printContractDetails2) {

		int compareTransferType = printContractDetails1.getTransfer_type()
				.compareTo(printContractDetails2.getTransfer_type());
		int comparerateValidFrom = printContractDetails1.getValid_from()
				.compareTo(printContractDetails2.getValid_from());
		int compareRegion = printContractDetails1.getDestination()
				.compareTo(printContractDetails2.getDestination());
		int compareFrom = printContractDetails1.getFrom()
				.compareTo(printContractDetails2.getFrom());
		int compareTo = printContractDetails1.getTo()
				.compareTo(printContractDetails2.getTo());
		int compareTransportMethod = printContractDetails1.getTransport_method()
				.compareTo(printContractDetails2.getTransport_method());

		if (compareTransferType == 0) {

			if (comparerateValidFrom == 0) {

				if (compareRegion == 0) {

					if (compareFrom == 0) {
						return ((compareTo == 0) ? compareTransportMethod : compareTo);
					} else {
						return compareFrom;
					}

				} else {
					return compareRegion;
				}

			} else {
				return comparerateValidFrom;
			}

		} else {
			return compareTransferType;
		}
	}
}
