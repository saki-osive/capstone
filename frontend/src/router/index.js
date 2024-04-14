import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/Login.vue'
import ProcessorIndex from '@/stakeholderScreens/processor/ProcessorIndex.vue'
import OnBoardingIndex from '@/stakeholderScreens/onBoarding/OnBoardingIndex.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/login',
        props: true,
    },
    {
        path: '/login',
        name: 'Login',
        props: true,
        component: Login,
    },
    {
        path: '/register',
        name: 'Register',
        props: true,
        component: () => import('@/views/Register.vue'),
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('@/dashboard/Dashboard.vue'),
        props: true,
    },

    /** 2. Processor Stakeholder */

    {
        path: '/processor',
        name: 'ProcessorIndex',
        props: true,
        component: ProcessorIndex,
        children: [
            {
                path: 'dashboard',
                name: 'ProcessorDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/ProcessorDashboard.vue'
                    ),
            },
            {
                path: 'addFarmer',
                name: 'AddFarmer',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/addFarmer/AddFarmer.vue'
                    ),
            },
            {
                path: 'farmerAdded',
                name: 'FarmerAdded',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/addFarmer/FarmerAdded.vue'
                    ),
            },
            {
                path: 'viewAll',
                name: 'ViewAll',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/ViewAll.vue'
                    ),
            },
            {
                path: 'farmerDetails',
                name: 'FarmerDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/pendingForReview/FarmerDetails.vue'
                    ),
            },
            {
                path: 'pendingForReview',
                name: 'PendingForReview',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/pendingForReview/PendingForReview.vue'
                    ),
            },
            {
                path: 'farmerRegistered',
                name: 'FarmerRegistered',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/pendingForReview/FarmerRegistered.vue'
                    ),
            },
            {
                path: 'suspendedFarmer',
                name: 'SuspendedFarmer',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/processor/src/SuspendedFarmer.vue'
                    ),
            },
        ],
    },


    /** 9. CVO Stakeholder */

    {
        path: '/cvo',
        name: 'CVOIndex',
        component: () =>
            import('@/stakeholderScreens/chiefVigilanceOfficer/CVOIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'CVODashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/chiefVigilanceOfficer/CVODashboard.vue'
                    ),
            },
            {
                path: 'cvoProfile',
                name: 'CVOProfile',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/chiefVigilanceOfficer/src/CVOProfile.vue'
                    ),
            },
        ],
    },

    /** 4. Retailer Stakeholder */

    {
        path: '/retailer',
        name: 'RetailerIndex',
        props: true,
        component: () =>
            import('@/stakeholderScreens/retailer/RetailerIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'RetailerDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/RetailerDashboard.vue'
                    ),
            },
            {
                path: 'activeLots',
                name: 'ActiveLots',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/ActiveLots.vue'
                    ),
            },
            {
                path: 'review/pending',
                name: 'PendingReview',

                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/pendingReview/PendingReviewMain.vue'
                    ),
            },
            {

                path: 'review/lotDetails',
                name: 'LotDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/pendingReview/LotDetails.vue'
                    ),
            },
            {
                name: 'RejectedLotDetails',
                path: 'RejectedLotDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/RejectedLotDetails.vue'
                    ),
            },

            {
                path: 'markedCorregendum',
                name: 'MarkedCorregendum',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/pendingReview/Corregendum.vue'
                    ),
            },
            {
                path: 'review/success',
                name: 'AcceptLot',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/pendingReview/AcceptLot.vue'
                    ),
            },
            {
                name: 'RejectLot',
                path: 'rejectLot',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/pendingReview/RejectLot.vue'
                    ),
            },
            {
                path: 'rejectedLots',
                name: 'RejectedLots',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/RejectedLots.vue'
                    ),
            },

            {
                path: 'UpcomingLots',
                name: 'UpcomingLots',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/upcoming/UpcomingLots.vue'
                    ),
            },
            {
                path: 'inviteProduct',
                name: 'InviteProduct',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/upcoming/InviteProduct.vue'
                    ),
            },
            {
                path: 'viewSubmissions',
                name: 'ViewSubmissions',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/ViewSubmissions.vue'
                    ),
            },
            {
                path: 'trackStatus',
                name: 'TrackStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/retailer/src/TrackStatus.vue'
                    ),
            },
        ],
    },

    /** 6. Onboarding */

    {
        path: '/onboarding',
        name: 'OnBoardingIndex',
        props: true,
        component: OnBoardingIndex,
        children: [
            {
                path: 'review/pending',
                name: 'UserPendingReview',
                props: true,
                component: () => import('@/stakeholderScreens/onBoarding/user/FarmerPendingReview.vue'),
            },
            {
                path: 'review/details',
                name: 'ReviewUser',
                props: true,
                component: () => import('@/stakeholderScreens/onBoarding/user/ReviewUser.vue'),
            },

            {
                path: 'addUser',
                name: 'AddUser',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/onBoarding/user/AddUser.vue'),
            },
            {
                path: 'viewAll',
                name: 'ViewAll',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/onBoarding/user/ViewAll.vue'),
            },
            {
                path: 'allUserRoles',
                name: 'AllUserRoles',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/onBoarding/user/AllUserRoles.vue'
                    ),
            },
            {
                path: 'OnboardingDashboard',
                name: 'OnboardingDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/onBoarding/OnboardingDashboard.vue'
                    ),
            },
        ],
    },

    /** 10. Auditor Stakeholder */

    {
       path: '/auditorIndex',
       name: 'AuditorIndex',
       component: () => import('@/stakeholderScreens/auditor/AuditorIndex.vue'),
       children: [
           {
            path: 'auditorDashboard',
            name: 'AuditorDashboard',
            component: () =>
                import(
                    '@/stakeholderScreens/auditor/AuditorDashboard.vue'
                ), 
           },
           {
               path: 'auditLogs',
               name: 'AuditorLogs',
               component: () =>
                   import(
                       '@/stakeholderScreens/auditor/AuditorLogs.vue'
                       ),
           },
       ]
    },

    /** 7. Consumer Stakeholder */

    {
        path: '/consumer',
        name: 'ConsumerIndex',
        props: true,
        component: () =>
            import('@/stakeholderScreens/consumer/ConsumerIndex'),
        children: [
            {
                path: 'assignedProducts',
                name: 'AssignedProducts',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/consumer/src/AssignedProducts.vue'
                    ),
            },

            {
                path: 'profile',
                name: 'ConsumerProfile',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/consumer/src/ConsumerProfile.vue'),
            },
            {
                path: 'notifications',
                name: 'Notifications',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/consumer/src/Notifications.vue'),
            },

            {
                path: 'consumerScanner',
                name: 'ConsumerScanner',
                props: true,
                component: () => import('@/stakeholderScreens/consumer/src/ConsumerScanner.vue'),
            },

            {
                path: 'productJourney',
                name: 'ProductJourney',
                component: () => import('@/stakeholderScreens/consumer/src/ProductJourney.vue')
            },

            {
                path: 'dashboard',
                name: 'ConsumerDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/consumer/ConsumerDashboard.vue'
                    ),
            },

            {
                path: 'reviewTechnicalProduct',
                name: 'ReviewTechnicalProduct',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/consumer/src/ReviewTechnicalProduct.vue'
                    ),
            },

            {
                path: 'reviewFinancialProduct',
                props: true,
                name: 'ReviewFinancialProduct',
                component: () =>
                    import(
                        '@/stakeholderScreens/consumer/src/ReviewFinancialProduct.vue'
                    ),
            },

            // TODO:: Confirm if this section needs to be kept
            {
                path: 'reviewProduct',
                name: 'ReviewProduct',
                component: () =>
                    import(
                        '@/stakeholderScreens/consumer/src/ReviewProduct-bak.vue'
                    ),
                children: [
                    {
                        path: 'administrativeEval',
                        name: 'AdministrativeEval',
                        component: () =>
                            import(
                                '@/stakeholderScreens/consumer/src/reviewProduct-bak/AdministrativeEval.vue'
                            ),
                    },
                    {
                        path: 'technicalEval',
                        name: 'TechnicalEval',
                        component: () =>
                            import(
                                '@/stakeholderScreens/consumer/src/reviewProduct-bak/TechnicalEval.vue'
                            ),
                    },
                    {
                        path: 'financialEval',
                        name: 'FinancialEval',
                        component: () =>
                            import(
                                '@/stakeholderScreens/consumer/src/reviewProduct-bak/FinancialEval.vue'
                            ),
                    },
                    {
                        path: 'performance',
                        name: 'PerformanceProductEval',
                        component: () =>
                            import(
                                '@/stakeholderScreens/consumer/src/reviewProduct-bak/Performance.vue'
                            ),
                    },
                    {
                        path: 'awardCertificate',
                        name: 'AwardCertificate',
                        component: () =>
                            import(
                                '@/stakeholderScreens/consumer/src/reviewProduct-bak/AwardCertificate.vue'
                            ),
                    },
                ],
            },
        ],
    },

    /** 8. Government Stakeholder */

    {
        path: '/government',
        name: 'GovernmentIndex',
        props: true,
        component: () =>
            import(
                '@/stakeholderScreens/government/GovernmentIndex.vue'
            ),
        children: [
            {
                path: 'dashboard',
                name: 'GovernmentDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/GovernmentDashboard.vue'
                    ),
            },
            {
                path: 'activeLots',
                name: 'ActiveLotsForGovernment',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/ActiveLotsForGovernment.vue'
                    ),
            },

            {
                path: 'LotDetailsForGovernment',
                name: 'LotDetailsForGovernment',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/LotDetailsForGovernment.vue'
                    ),
            },
            {
                path: 'pendingAssignments',
                name: 'PendingAssignments',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/PendingAssignments.vue'
                    ),
            },
            {
                path: 'viewAll',
                name: 'ViewAllProducts',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/ViewAllProducts.vue'
                    ),
            },
            {
                path: 'assignExpert',
                name: 'AssignExpert',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/assignExpert/AssignExperts.vue'
                    ),
            },
            {
                path: 'trackProductStatus',
                name: 'TrackProductStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/government/src/trackProductStatusMain.vue'
                    ),
                children: [
                    {
                        path: 'status',
                        name: 'TrackProductStatus',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/government/src/trackProductStatus/TrackProductStatus.vue'
                            ),
                    },
                    {
                        path: 'scoredResponses',
                        name: 'ScoredResponses',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/government/src/trackProductStatus/ScoredResponses.vue'
                            ),
                    },
                    {
                        path: 'resultSummary',
                        name: 'ResultSummary',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/government/src/trackProductStatus/ResultSummary.vue'
                            ),
                    },
                    {
                        path: 'evaluationReport',
                        name: 'EvaluationReport',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/government/src/trackProductStatus/EvaluationReport.vue'
                            ),
                    },
                ],
            },
        ],
    },

    /** 1. Farmer Stakeholder */

    {
        path: '/farmer',
        name: 'FarmerIndex',
        props: true,
        component: () => import('@/stakeholderScreens/farmer/FarmerIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'FarmerDashboard',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/FarmerDashboard.vue'),
            },
            {
                path: 'profile',
                name: 'FarmerProfile',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/FarmerProfile.vue'),
            },
            {
                path: 'submittedProducts',
                name: 'SubmittedProducts',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/submittedProducts.vue'),
            },
            {
                path: 'approvedProducts',
                name: 'ApprovedProducts',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/ApprovedProducts.vue'),
            },
            {
                path: 'bookForFreight',
                name: 'BookForFreight',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/BookForFreight.vue'),
            },
            {
                path: 'bookForSupplier',
                name: 'BookForSupplier',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/BookForSupplier.vue'),
            },
            {
                path: 'bookedForFreightConfirmationScreen',
                name: 'BookedForFreightConfirmationScreen',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/BookedForFreightConfirmationScreen.vue'),
            },
            {
                path: 'bookedForSupplierConfirmationScreen',
                name: 'BookedForSupplierConfirmationScreen',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/BookedForSupplierConfirmationScreen.vue'),
            },
            {
                path: 'submittedProducts/productStatus',
                name: 'ProductTrackStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/farmer/src/ProductTrackStatus.vue'
                    ),
            },
            {
                path: 'notifications',
                name: 'FarmerNotifications',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/FarmerNotifications.vue'),
            },
            // {
            //     path: 'lotRecordsList',
            //     name: 'LotRecordsList',
            //     props: true,
            //     component: () =>
            //         import('@/stakeholderScreens/farmer/src/LotRecordsList.vue'),
            // },
            {
                path: 'lotRecordsList',
                name: 'CreateLotThroughFarmerDemo',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/farmer/src/CreateLotThroughFarmerDemo.vue'),
            },
            {
                path: 'modeOfTransport',
                name: 'ModeOfTransportFarmer',
                component: () => import('@/stakeholderScreens/farmer/src/ModeOfTransportFarmer.vue')
            },
            {
                path: 'activeLots',
                name: 'ActiveLotsView',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/farmer/src/ActiveLotsView.vue'
                    ),
            },
            {
                path: 'submitProduct',
                name: 'SubmitProduct',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/farmer/src/SubmitProduct.vue'
                    ),
            },
            {
                path: 'lotDetailsForFarmer',
                name: 'LotDetailsForFarmer',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/farmer/src/LotDetailsForFarmer.vue'
                    ),
            },
        ],
    },

    /** 3. Distributor Stakeholder */

    {
        path: '/distributor',
        name: 'DistributorIndex',
        props: true,
        component: () => import('@/stakeholderScreens/distributor/DistributorIndex.vue'),
        children: [
            {
                path: 'distributorDashboard',
                name: 'DistributorDashboard',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/distributor/DistributorDashboard.vue'),
            },
            {
                path: 'producerProductLots',
                name: 'ProducerProductLots',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/distributor/src/ProducerProductLots.vue'),
            },
            {
                path: 'allProductLots',
                name: 'AllProductLots',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/distributor/src/AllProductLots.vue'),
            },
            {
                path: 'trackProductLots',
                name: 'TrackProductLots',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/distributor/src/TrackProductLots.vue'),
            },

        ],
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
})

export default router
