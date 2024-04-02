

export const TenderTableHeaders = {
    header: [
        {
            text: 'Tender Id',
            value: 'id',
        },
        {
            text: 'Tender Name',
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
            text: 'Bidding System',
            value: 'typeOfBiddingSystem',
        },
        {
            text: '',
            value: 'view',
        },
    ],
    getHeaderForPendingReview: function getHeaderForPendingReview(){

        var allHeaders = JSON.parse(JSON.stringify(TenderTableHeaders.header));

        allHeaders.push({
            text: 'Review',
            value: 'review',
        });
        return allHeaders;
    }
};