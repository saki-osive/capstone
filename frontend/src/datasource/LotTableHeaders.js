

export const LotTableHeaders = {
    header: [
        {
            text: 'Lot Id',
            value: 'id',
        },
        {
            text: 'Lot Name',
            value: 'scopeOfWork',
        },
        {
            text: 'Type',
            value: 'type',
        },
        {
            text: 'Submission Date',
            value: 'referenceDate',
        },
        {
            text: 'Product Category',
            value: 'category',
        },
        {
            text: 'Product Id',
            value: 'typeOfProductdingSystem',
        },
        {
            text: '',
            value: 'view',
        },
    ],
    getHeaderForPendingReview: function getHeaderForPendingReview(){

        var allHeaders = JSON.parse(JSON.stringify(LotTableHeaders.header));

        allHeaders.push({
            text: 'Review',
            value: 'review',
        });
        return allHeaders;
    }
};