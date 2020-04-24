package com.example.internetconnectionsample;

import java.util.List;

@SuppressWarnings("all")
public class Book {
    private final String kind;

    private final int totalItems;

    private final List<Items> items;

    public Book(String kind, int totalItems, List<Items> items) {
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<Items> getItems() {
        return items;
    }

    public static class Items {
        private final String kind;

        private final String id;

        private final String etag;

        private final String selfLink;

        private final VolumeInfo volumeInfo;

        private final SaleInfo saleInfo;

        private final AccessInfo accessInfo;

        private final SearchInfo searchInfo;

        public Items(String kind, String id, String etag, String selfLink, VolumeInfo volumeInfo,
                     SaleInfo saleInfo, AccessInfo accessInfo, SearchInfo searchInfo) {
            this.kind = kind;
            this.id = id;
            this.etag = etag;
            this.selfLink = selfLink;
            this.volumeInfo = volumeInfo;
            this.saleInfo = saleInfo;
            this.accessInfo = accessInfo;
            this.searchInfo = searchInfo;
        }

        public String getKind() {
            return kind;
        }

        public String getId() {
            return id;
        }

        public String getEtag() {
            return etag;
        }

        public String getSelfLink() {
            return selfLink;
        }

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        public SaleInfo getSaleInfo() {
            return saleInfo;
        }

        public AccessInfo getAccessInfo() {
            return accessInfo;
        }

        public SearchInfo getSearchInfo() {
            return searchInfo;
        }

        public static class VolumeInfo {
            private final String title;

            private final List<String> authors;

            private final String publisher;

            private final String publishedDate;

            private final String description;

            private final List<IndustryIdentifiers> industryIdentifiers;

            private final ReadingModes readingModes;

            private final int pageCount;

            private final String printType;

            private final List<String> categories;

            private final String maturityRating;

            private final boolean allowAnonLogging;

            private final String contentVersion;

            private final PanelizationSummary panelizationSummary;

            private final ImageLinks imageLinks;

            private final String language;

            private final String previewLink;

            private final String infoLink;

            private final String canonicalVolumeLink;

            public VolumeInfo(String title, List<String> authors, String publisher,
                              String publishedDate, String description,
                              List<IndustryIdentifiers> industryIdentifiers, ReadingModes readingModes,
                              int pageCount, String printType, List<String> categories, String maturityRating,
                              boolean allowAnonLogging, String contentVersion,
                              PanelizationSummary panelizationSummary, ImageLinks imageLinks, String language,
                              String previewLink, String infoLink, String canonicalVolumeLink) {
                this.title = title;
                this.authors = authors;
                this.publisher = publisher;
                this.publishedDate = publishedDate;
                this.description = description;
                this.industryIdentifiers = industryIdentifiers;
                this.readingModes = readingModes;
                this.pageCount = pageCount;
                this.printType = printType;
                this.categories = categories;
                this.maturityRating = maturityRating;
                this.allowAnonLogging = allowAnonLogging;
                this.contentVersion = contentVersion;
                this.panelizationSummary = panelizationSummary;
                this.imageLinks = imageLinks;
                this.language = language;
                this.previewLink = previewLink;
                this.infoLink = infoLink;
                this.canonicalVolumeLink = canonicalVolumeLink;
            }

            public String getTitle() {
                return title;
            }

            public List<String> getAuthors() {
                return authors;
            }

            public String getPublisher() {
                return publisher;
            }

            public String getPublishedDate() {
                return publishedDate;
            }

            public String getDescription() {
                return description;
            }

            public List<IndustryIdentifiers> getIndustryIdentifiers() {
                return industryIdentifiers;
            }

            public ReadingModes getReadingModes() {
                return readingModes;
            }

            public int getPageCount() {
                return pageCount;
            }

            public String getPrintType() {
                return printType;
            }

            public List<String> getCategories() {
                return categories;
            }

            public String getMaturityRating() {
                return maturityRating;
            }

            public boolean isAllowAnonLogging() {
                return allowAnonLogging;
            }

            public String getContentVersion() {
                return contentVersion;
            }

            public PanelizationSummary getPanelizationSummary() {
                return panelizationSummary;
            }

            public ImageLinks getImageLinks() {
                return imageLinks;
            }

            public String getLanguage() {
                return language;
            }

            public String getPreviewLink() {
                return previewLink;
            }

            public String getInfoLink() {
                return infoLink;
            }

            public String getCanonicalVolumeLink() {
                return canonicalVolumeLink;
            }

            public static class IndustryIdentifiers {
                private final String type;

                private final String identifier;

                public IndustryIdentifiers(String type, String identifier) {
                    this.type = type;
                    this.identifier = identifier;
                }

                public String getType() {
                    return type;
                }

                public String getIdentifier() {
                    return identifier;
                }
            }

            public static class ReadingModes {
                private final boolean text;

                private final boolean image;

                public ReadingModes(boolean text, boolean image) {
                    this.text = text;
                    this.image = image;
                }

                public boolean isText() {
                    return text;
                }

                public boolean isImage() {
                    return image;
                }
            }

            public static class PanelizationSummary {
                private final boolean containsEpubBubbles;

                private final boolean containsImageBubbles;

                public PanelizationSummary(boolean containsEpubBubbles,
                                           boolean containsImageBubbles) {
                    this.containsEpubBubbles = containsEpubBubbles;
                    this.containsImageBubbles = containsImageBubbles;
                }

                public boolean isContainsEpubBubbles() {
                    return containsEpubBubbles;
                }

                public boolean isContainsImageBubbles() {
                    return containsImageBubbles;
                }
            }

            public static class ImageLinks {
                private final String smallThumbnail;

                private final String thumbnail;

                public ImageLinks(String smallThumbnail, String thumbnail) {
                    this.smallThumbnail = smallThumbnail;
                    this.thumbnail = thumbnail;
                }

                public String getSmallThumbnail() {
                    return smallThumbnail;
                }

                public String getThumbnail() {
                    return thumbnail;
                }
            }
        }

        public static class SaleInfo {
            private final String country;

            private final String saleability;

            private final boolean isEbook;

            public SaleInfo(String country, String saleability, boolean isEbook) {
                this.country = country;
                this.saleability = saleability;
                this.isEbook = isEbook;
            }

            public String getCountry() {
                return country;
            }

            public String getSaleability() {
                return saleability;
            }

            public boolean isEbook() {
                return isEbook;
            }
        }

        public static class AccessInfo {
            private final String country;

            private final String viewability;

            private final boolean embeddable;

            private final boolean publicDomain;

            private final String textToSpeechPermission;

            private final Epub epub;

            private final Pdf pdf;

            private final String webReaderLink;

            private final String accessViewStatus;

            private final boolean quoteSharingAllowed;

            public AccessInfo(String country, String viewability, boolean embeddable,
                              boolean publicDomain, String textToSpeechPermission, Epub epub, Pdf pdf,
                              String webReaderLink, String accessViewStatus, boolean quoteSharingAllowed) {
                this.country = country;
                this.viewability = viewability;
                this.embeddable = embeddable;
                this.publicDomain = publicDomain;
                this.textToSpeechPermission = textToSpeechPermission;
                this.epub = epub;
                this.pdf = pdf;
                this.webReaderLink = webReaderLink;
                this.accessViewStatus = accessViewStatus;
                this.quoteSharingAllowed = quoteSharingAllowed;
            }

            public String getCountry() {
                return country;
            }

            public String getViewability() {
                return viewability;
            }

            public boolean isEmbeddable() {
                return embeddable;
            }

            public boolean isPublicDomain() {
                return publicDomain;
            }

            public String getTextToSpeechPermission() {
                return textToSpeechPermission;
            }

            public Epub getEpub() {
                return epub;
            }

            public Pdf getPdf() {
                return pdf;
            }

            public String getWebReaderLink() {
                return webReaderLink;
            }

            public String getAccessViewStatus() {
                return accessViewStatus;
            }

            public boolean isQuoteSharingAllowed() {
                return quoteSharingAllowed;
            }

            public static class Epub {
                private final boolean isAvailable;

                public Epub(boolean isAvailable) {
                    this.isAvailable = isAvailable;
                }

                public boolean isAvailable() {
                    return isAvailable;
                }
            }

            public static class Pdf {
                private final boolean isAvailable;

                private final String acsTokenLink;

                public Pdf(boolean isAvailable, String acsTokenLink) {
                    this.isAvailable = isAvailable;
                    this.acsTokenLink = acsTokenLink;
                }

                public boolean isAvailable() {
                    return isAvailable;
                }

                public String getAcsTokenLink() {
                    return acsTokenLink;
                }
            }
        }

        public static class SearchInfo {
            private final String textSnippet;

            public SearchInfo(String textSnippet) {
                this.textSnippet = textSnippet;
            }

            public String getTextSnippet() {
                return textSnippet;
            }
        }
    }
}
